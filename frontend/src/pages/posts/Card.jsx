import React from "react";

export default function PostCard({ post, onDeleteClick }) {
  return (
    <div className="card mt-3">
      <div className="card-body">
        <p>{post.body}</p>

        <button className="btn btn-danger" onClick={onDeleteClick}>
          Delete
        </button>
      </div>
    </div>
  );
}
