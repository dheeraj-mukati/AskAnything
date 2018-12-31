import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  getCategories(){
    return this.http.get('http://localhost:8080/categories');
  }

  getQuestions(){
    return this.http.get('http://localhost:8080/questions');
  }

  getQuestionsByCategory(categoryId){
    return this.http.get('http://localhost:8080/questions/categories/'+categoryId);
  }

  getAnswers(questionId){
    return this.http.get('http://localhost:8080/answers/questions/'+questionId);
  }
}
