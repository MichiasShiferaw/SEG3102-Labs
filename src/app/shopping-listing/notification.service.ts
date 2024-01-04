import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ItemEntry } from './item-entry';


@Injectable()
export class NotificationService {

  selectedElement = new BehaviorSubject<ItemEntry | null>(null);
  constructor() { }

  public selectionChanged(item: ItemEntry): void{
    this.selectedElement.next(item);
  }
}
