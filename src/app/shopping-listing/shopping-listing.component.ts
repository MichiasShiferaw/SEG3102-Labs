import { Component, Input } from '@angular/core';
import { ItemEntry } from './item-entry';
import { NotificationService } from './notification.service';


@Component({
  selector: 'app-shopping-listing',
  templateUrl: './shopping-listing.component.html',
  styleUrls: ['./shopping-listing.component.css'],
  providers: [NotificationService]
})
export class ShoppingListingComponent {
  item: ItemEntry = new ItemEntry(1,'') ;
  items: ItemEntry[] = [];
  edit: boolean | undefined;
  currentItem: ItemEntry | null = null;
  constructor(private notificationService: NotificationService){}


  select(item:ItemEntry): void{
    this.currentItem=item;
    this.notificationService.selectionChanged(item);
  }

  addItem(): void{
    if (this.item.itemName.length>0){
    const newItem = new ItemEntry(this.item.quantity,this.item.itemName);
    this.items= [newItem,...this.items];
    this.select(newItem)
    this.item.quantity=1;
    this.item.itemName="";
    }
  }

  deleteCurrent(itemOne:ItemEntry): void{

    this.items= this.items.filter((item: ItemEntry)=> item !== itemOne);
    this.currentItem = null;
  }


}
