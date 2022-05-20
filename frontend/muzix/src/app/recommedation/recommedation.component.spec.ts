import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommedationComponent } from './recommedation.component';

describe('RecommedationComponent', () => {
  let component: RecommedationComponent;
  let fixture: ComponentFixture<RecommedationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecommedationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommedationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
