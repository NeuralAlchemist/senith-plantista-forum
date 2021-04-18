import React from "react";

export default function Comment({ comment, onDeleteClick }) {
    // Methods
    const handleDelete = () => {
        // Invoke the passed in event callback
        onDeleteClick(comment);
    };
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>{comment.body}</p>

                <button className="btn btn-danger" onClick={handleDelete}>
                    Delete
                </button>
            </div>
        </div>
    );
}
