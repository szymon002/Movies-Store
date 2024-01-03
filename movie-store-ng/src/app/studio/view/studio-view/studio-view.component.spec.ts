import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudioViewComponent } from './studio-view.component';

describe('StudioViewComponent', () => {
  let component: StudioViewComponent;
  let fixture: ComponentFixture<StudioViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudioViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StudioViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
