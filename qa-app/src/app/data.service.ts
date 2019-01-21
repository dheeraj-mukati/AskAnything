import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import {QuestionM} from '../model/questionM';
import {AnswerM} from '../model/answerM';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private questionUrl = "http://localhost:8081/questions";
  private categoryUrl = "http://localhost:8081/categories";
  private answerUrl = "http://localhost:8081/answers";


  constructor(private http: HttpClient) { }

  getCategories(){
    return this.http.get(this.categoryUrl);
  }

  getQuestions(){
    return this.http.get(this.questionUrl);
  }

  getQuestionsByCategory(categoryId){
    return this.http.get('http://localhost:8081/questions/categories/'+categoryId);
  }

  getAnswers(questionId){
    return this.http.get('http://localhost:8081/answers/questions/'+questionId);
  }

  createQuestion(questionM){
    return this.http.post(this.questionUrl,questionM);
  }

  createAnswer(answerM){
    return this.http.post(this.answerUrl,answerM);
  }
}
