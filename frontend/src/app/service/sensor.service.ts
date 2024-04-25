import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sensor } from '../model/Sensor';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment'; 

@Injectable({
  providedIn: 'root'
})
export class SensorService {
  constructor(
    private http: HttpClient
  ) { }

  create(sensor: Sensor): Observable<Sensor> {
    return this.http.post<Sensor>(`${environment.apiUrl}/sensor`, sensor);
  }

  getAll(): Observable<Sensor[]> {
    return this.http.get<Sensor[]>(`${environment.apiUrl}/sensor`);
  }
  
  getById(id: number): Observable<Sensor> {
    return this.http.get<Sensor>(`${environment.apiUrl}/sensor`, {params: {"id": id}});
  }

  update(sensor: Sensor): Observable<Sensor> {
    return this.http.put<Sensor>(`${environment.apiUrl}/sensor`, sensor);
  }

  delete(id: number): Observable<Object> {
    return this.http.delete(`${environment.apiUrl}/sensor`, {params: {"id": id}});
  }

}
