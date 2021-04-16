import React from "react";

export default function CommentForm({ onSubmit }) {
    const [commentBody, setCommentBody] = React.useState("");

    const handleSubmit = () => {
        // Invoke the passed in event callback
        onSubmit({ body: commentBody });

        // Clear the input field
        setCommentBody("");
    };

    //Todo 1) connect ... a) as child component to PostCard and b) send info to Comment.jsx
    return (
        <div className="card">
            <div className="card-body">
                <h4 className="card-title">Share your comment</h4>
                <div>
                    <div className="form-group">
            <textarea
                className="form-control"
                value={commentBody}
                onChange={(e) => setCommentBody(e.target.value)}
            />
                    </div>

                    <div className="form-group">
                        <button className="btn btn-success" onClick={handleSubmit}>
                            Post
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}
