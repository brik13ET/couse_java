import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Room } from '../model/Room';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment'; 
import { Sensor } from '../model/Sensor';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  constructor(
    private http: HttpClient
  ) { }

  create(room: Room): Observable<Room> {
    return this.http.post<Room>(`${environment.apiUrl}/room`, room);
  }

  getAll(): Observable<Room[]> {
    return this.http.get<Room[]>(`${environment.apiUrl}/room`);
  }
  
  getById(id: number): Observable<Room> {
    return this.http.get<Room>(`${environment.apiUrl}/room/${id}`);
  }
  getSensorsById(id: number): Observable<Sensor[]> {
    return this.http.get<Sensor[]>(`${environment.apiUrl}/room/${id}/sensors`);
  }

  update(room: Room): Observable<Room> {
    return this.http.put<Room>(`${environment.apiUrl}/room/${room.id}`, room);
  }

  delete(id: number): Observable<Object> {
    return this.http.delete(`${environment.apiUrl}/room/${id}`);
  }

}
