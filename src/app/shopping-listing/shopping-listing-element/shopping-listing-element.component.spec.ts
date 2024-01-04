import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingListingElementComponent } from './shopping-listing-element.component';

describe('ShoppingListingElementComponent', () => {
  let component: ShoppingListingElementComponent;
  let fixture: ComponentFixture<ShoppingListingElementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShoppingListingElementComponent]
    });
    fixture = TestBed.createComponent(ShoppingListingElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
