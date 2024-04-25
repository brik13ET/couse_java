import { Routes					} from '@angular/router';
import { SensorWrapperComponent } from './components/misc/sensor-wrapper/sensor-wrapper.component';
import { RoomWrapperComponent } from './components/misc/room-wrapper/room-wrapper.component';
import { BuildingWrapperComponent } from './components/misc/building-wrapper/building-wrapper.component';

export const routes: Routes = [
    { path: ''		, redirectTo: '/building', pathMatch: 'full'},
    { path: 'sensor'    	, component: SensorWrapperComponent     },
    { path: 'sensor/:id'	, component: SensorWrapperComponent     },
    { path: 'room'	    	, component: RoomWrapperComponent       },
    { path: 'room/:id'		, component: RoomWrapperComponent       },
    { path: 'building'      , component: BuildingWrapperComponent   },
    { path: 'building/:id'  , component: BuildingWrapperComponent   },
    { path: '**'	, redirectTo: '/building', pathMatch: 'full'}
];
