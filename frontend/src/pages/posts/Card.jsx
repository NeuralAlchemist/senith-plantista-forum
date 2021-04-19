// NPM Package
import React, { useEffect, useState } from "react";

// Project files
import CommentForm from "./comments/CommentForm";
import CommentList from "./comments/CommentList";
import CommentsApi from "../../api/CommentsApi";
import PostUpdate from "./PostUpdate";

export default function PostCard({ post, onDeleteClick }) {
    // Local state
    const [comments, setComments] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const[postBody, setPostBody] = useState(post.body);

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
        <p>{postBody}</p>

        <button className="btn btn-danger" onClick={onDeleteClick}>
          Delete
        </button>

          <PostUpdate onSubmite={(newBody)=>setPostBody(newBody)}
                      postId={post.id}/>
      </div>

        <CommentForm post={post} onSubmit={createComment}/>
        <CommentList comments={comments} onDelete={deleteComment}/>
    </div>
  );
}
