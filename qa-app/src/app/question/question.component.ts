import { Component, OnInit } from '@angular/core';

import { DataService } from '../data.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from "@angular/router";

import { QuestionM } from '../model/questionM';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  category$: Number
  questions$: QuestionM[]
  questionM: QuestionM = new QuestionM();

  constructor(private data: DataService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => this.category$ = params.id
    )
  }

  ngOnInit() {
    this.data.getQuestionsByCategory(this.category$).subscribe(
      data => this.questions$ = data
    )
  }

  createQuestion() {

    this.questionM.userId = 108;
    this.questionM.category = +this.category$;

    this.data.createQuestion(this.questionM).subscribe(
      data => {
        console.log('Question created')
        this.questionM = new QuestionM();
        this.ngOnInit();
      }
    )
  }
}
