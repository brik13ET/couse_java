import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Building } from '../../../model/Building';
import { RouterModule } from '@angular/router';
import { BuildingService } from '../../../service/building.service';

@Component({
  selector: 'app-building-card',
  templateUrl: './building-card.component.html',
  styleUrl: './building-card.component.css',
  standalone: true,
  imports: [RouterModule]
})
export class BuildingCardComponent {
  @Input() public building!: [b: Building, rooms: number];
  @Output() upd = new EventEmitter();
  constructor(private service: BuildingService) { }

  delete() {
    this.service.delete(this.building[0].id).subscribe(() => {this.upd.emit();});
    
  }
}
