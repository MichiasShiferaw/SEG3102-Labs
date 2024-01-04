import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingListingComponent } from './shopping-listing.component';

describe('ShoppingListingComponent', () => {
  let component: ShoppingListingComponent;
  let fixture: ComponentFixture<ShoppingListingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShoppingListingComponent]
    });
    fixture = TestBed.createComponent(ShoppingListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
