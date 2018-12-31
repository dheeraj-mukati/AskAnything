import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {UserComponent} from './user/user.component';
import {CategoryComponent} from './category/category.component';
import {QuestionComponent} from './question/question.component';
import {AnswerComponent} from './answer/answer.component';

const routes: Routes = [
  {
    path: '',
    component: UserComponent
  },
  {
    path: 'categories',
    component: CategoryComponent
  },
  {
    path: 'questions/:id',
    component: QuestionComponent
  },
  {
    path: 'answers/:id',
    component: AnswerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
