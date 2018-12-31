import { Component, OnInit } from '@angular/core';

import { DataService } from '../data.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  categories$: Object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getCategories().subscribe(
      data => this.categories$ = data
    );
  }

}
