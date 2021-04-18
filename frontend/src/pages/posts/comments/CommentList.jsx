// NPM Packages
import React from "react";

// Project files
import Comment from "./Comment";

export default function CommentList({ comments, onDelete }) {
    // Components
    const CommentsArray = comments.map((comment) => (
        <Comment key={comment.id} comment={comment} onDeleteClick={onDelete} />
    ));

    return (
        <div>
            {CommentsArray}
        </div>
    )

}