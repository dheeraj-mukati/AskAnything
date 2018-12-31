import { Component, OnInit } from '@angular/core';

import { DataService } from '../data.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  category$: Object;
  questions$: Object;

  constructor(private data: DataService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => this.category$ = params.id
    )
  }

  ngOnInit() {
    this.data.getQuestionsByCategory(this.category$).subscribe(
      data => this.questions$ = data
    );
  }

}
