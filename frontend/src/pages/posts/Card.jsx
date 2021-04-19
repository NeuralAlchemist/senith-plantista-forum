// NPM Package
import React, { useEffect, useState } from "react";

// Project files
import CommentForm from "./comments/CommentForm";
import CommentList from "./comments/CommentList";
import CommentsApi from "../../api/CommentsApi";

export default function PostCard({ post, onDeleteClick }) {
    // Local state
    const [comments, setComments] = useState([]);

    // Components
    const postId = post.id;

    // Methods
    async function createComment(postId, commentData) {
        try {
            const response = await CommentsApi.createComment(postId, commentData);
            const comment = response.data;
            const newComments = comments.concat(comment);
            setComments(newComments);
        } catch (e) {
            console.error(e);
        }
    }

    async function deleteComment(commentToDelete) {
        try {
            await CommentsApi.deleteComment(commentToDelete.id);
            const newComments = comments.filter((comment) => comment.id !== commentToDelete.id);
            setComments(newComments);
        } catch(e) {
            console.error(e);
        }
    }

    useEffect( () => {
        CommentsApi.getAllComments(postId)
            .then(({data}) => setComments(data))
            .catch((err) => console.error(err));
    }, [setComments, postId]);

  return (
    <div className="card mt-3">
      <div className="card-body">
        <p>{post.body}</p>

        <button className="btn btn-danger" onClick={onDeleteClick}>
          Delete
        </button>


        {/* The text input for an updated Post should be here*/}
        <button className="btn btn-danger" onClick={onUpdateClick}>
          Update
        </button>

      </div>

        <CommentForm post={post} onSubmit={createComment}/>
        <CommentList comments={comments} onDelete={deleteComment}/>
    </div>
  );
}
