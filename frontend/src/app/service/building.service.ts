import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Building } from '../model/Building';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment'; 
import { Room } from '../model/Room';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {
  constructor(
    private http: HttpClient
  ) { }

  create(building: Building): Observable<Building> {
    return this.http.post<Building>(`${environment.apiUrl}/building`, building);
  }

  getAll(): Observable<Building[]> {
    return this.http.get<Building[]>(`${environment.apiUrl}/building`);
  }
  
  getById(id: number): Observable<Building> {
    return this.http.get<Building>(`${environment.apiUrl}/building/${id}`);
  }

  getRoomsCount(): Observable<{[key: number]: number;}>
  {
    return this.http.get<{[key: number]: number;}>(`${environment.apiUrl}/building/room_count`);
  }

  getRooms(id: number): Observable<Room[]>
  {
    return this.http.get<Room[]>(`${environment.apiUrl}/building/${id}/rooms`);
  }

  update(building: Building): Observable<Building> {
    return this.http.put<Building>(`${environment.apiUrl}/building/${building.id}`, building);
  }

  delete(id: number): Observable<Object> {
    return this.http.delete(`${environment.apiUrl}/building/${id}`);
  }

}
