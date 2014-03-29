//
//  ViewController.m
//  BeaconTracker
//
//  Created by Matthias Krauß on 27.03.14.
//  Copyright (c) 2014 Matthias Krauß. All rights reserved.
//

#import "ViewController.h"
#import <CoreLocation/CoreLocation.h>

static NSString* MY_BEACON_UUID = @"16A2230E-0B8B-4D3D-BF83-36DA12001990";

@interface ViewController () <CLLocationManagerDelegate>

@property (strong) CLLocationManager* locationManager;
@property (strong) CLBeaconRegion* region;
@property (strong) NSUUID* beaconUUID;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];

    
    self.locationManager = [[CLLocationManager alloc] init];
    self.locationManager.delegate = self;
    if (!self.locationManager) {
        if (![CLLocationManager authorizationStatus]) {
            self.label.text = @"Location Services not allowed";
        } else {
            self.label.text = @"Location Services failed to initialize";
        }
        return;
    }

    self.beaconUUID = [[NSUUID alloc] initWithUUIDString:MY_BEACON_UUID];
    self.region = [[CLBeaconRegion alloc] initWithProximityUUID:self.beaconUUID identifier:MY_BEACON_UUID];
    self.label.text = @"Scanning for beacons...";
    [self.locationManager startRangingBeaconsInRegion:self.region];
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

// CLLocationManagerDelegate implementation

- (void)locationManager:(CLLocationManager *)manager didRangeBeacons:(NSArray *)beacons inRegion:(CLBeaconRegion *)region {
    CLBeacon* strongestBeacon = nil;
    for (CLBeacon* beacon in beacons) {
        if ((!strongestBeacon) || (beacon.rssi > strongestBeacon.rssi)) {
            strongestBeacon = beacon;
        }
    }
    if (strongestBeacon) {
        NSString* prox = @"unknown";
        switch (strongestBeacon.proximity) {
            case CLProximityImmediate: prox = @"immediate"; break;
            case CLProximityNear: prox = @"near"; break;
            case CLProximityFar: prox = @"far"; break;
            default: break;
        }
        self.label.text = [NSString stringWithFormat:@"Strongest beacon major: %i minor: %i proximity: %@ rssi: %i",
                           strongestBeacon.major.intValue,
                           strongestBeacon.minor.intValue,
                           prox,
                           strongestBeacon.rssi];
    } else {
        self.label.text = @"No beacon in range";
    }
    
}

- (void)locationManager:(CLLocationManager *)manager rangingBeaconsDidFailForRegion:(CLBeaconRegion *)region
              withError:(NSError *)error {
    NSLog(@"rangingBeaconsDidFailForRegion");
    self.label.text = @"beacon ranging failed";
}


@end
