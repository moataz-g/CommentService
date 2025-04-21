import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Comment {
  id?: number;
  text: string;
  likes: number;
  dislikes: number;
}

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private apiUrl = 'http://localhost:8089/commentService/comments'; // backend URL

  constructor(private http: HttpClient) {}

  getComments(): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.apiUrl}`);
  }

  addComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>(`${this.apiUrl}`, comment);
  }

  likeComment(id: number): Observable<Comment> {
    return this.http.post<Comment>(`${this.apiUrl}/${id}/like`, {});
  }

  dislikeComment(id: number): Observable<Comment> {
    return this.http.post<Comment>(`${this.apiUrl}/${id}/dislike`, {});
  }
}
