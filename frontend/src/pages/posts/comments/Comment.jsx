import React from "react";

export default function Comment({ comment, onDeleteClick }) {
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>{comment.body}</p>

                <button className="btn btn-danger" onClick={onDeleteClick}>
                    Delete
                </button>
            </div>
        </div>
    );
}
