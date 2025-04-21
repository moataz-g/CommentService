import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Comment, CommentService } from '../../services/comment.service';

@Component({
  selector: 'app-comment-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {
  comments: Comment[] = [];
  newComment: string = '';

  constructor(private commentService: CommentService) {}

  ngOnInit(): void {
    this.getAllComments();
  }

  getAllComments(): void {
    this.commentService.getComments().subscribe({
      next: data => {
        // Force logging IDs to confirm they exist
        console.log('Commentaires chargés :', data);
        data.forEach(c => console.log('ID:', c.id)); // <-- check here
        this.comments = data.map(c => ({
          id: c['id'], // explicitly access it
          text: c['text'],
          likes: c['likes'],
          dislikes: c['dislikes']
        }));
      },
      error: err => console.error('Erreur lors du chargement des commentaires:', err)
    });
    
  }
  
  

  addComment(): void {
    if (!this.newComment.trim()) return;

    const comment: Comment = {
      text: this.newComment,
      likes: 0,
      dislikes: 0
    };

    this.commentService.addComment(comment).subscribe(() => {
      this.newComment = '';
      this.getAllComments();
    });
  }

  like(id: number): void {
    this.commentService.likeComment(id).subscribe(() => this.getAllComments());
  }

  dislike(id: number): void {
    this.commentService.dislikeComment(id).subscribe(() => this.getAllComments());
  }
}
