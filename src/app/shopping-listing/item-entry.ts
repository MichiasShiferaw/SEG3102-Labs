export class ItemEntry {
  public itemName: string;
  public quantity: Number;


  constructor(quantity: Number,itemName: string ) {
    this.itemName = itemName;
    this.quantity = quantity;
  }
}
