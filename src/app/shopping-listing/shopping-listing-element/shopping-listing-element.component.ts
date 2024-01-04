import { Component,Input,OnDestroy,OnInit,EventEmitter, Output } from '@angular/core';
import { ItemEntry } from '../item-entry';
import {NotificationService} from '../notification.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-shopping-listing-element',
  templateUrl: './shopping-listing-element.component.html',
  styleUrls: ['./shopping-listing-element.component.css']
})
export class ShoppingListingElementComponent implements OnInit, OnDestroy {
  @Input() item!: ItemEntry;
  @Output() fireDelete: EventEmitter<ItemEntry> = new EventEmitter();
  selected = false;
  subscription: Subscription | undefined;
  edit: boolean | undefined;

   constructor(private notificationService: NotificationService) {
  }


  ngOnInit(): void {
    this.subscription = this.notificationService.selectedElement.subscribe(newItem => {
      this.selected = newItem === this.item ? true : false;
    });
  }

  getFullItemName(): string {
    return `${this.item!.quantity} ${this.item!.itemName}(s)`;
  }

  ngOnDestroy(): void {
    this.subscription!.unsubscribe();
  }

    delete(): void {
      this.fireDelete.emit(this.item);
    }




}
