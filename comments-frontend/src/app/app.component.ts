import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommentListComponent } from './components/comment-list/comment-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HttpClientModule,  // 👈 Add this line!
    CommentListComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'comments-frontend';
}
