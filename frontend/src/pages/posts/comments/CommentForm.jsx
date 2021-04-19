import React from "react";

export default function CommentForm({ post, onSubmit }) {
    const [commentBody, setCommentBody] = React.useState("");

    const handleSubmit = () => {
        // Invoke the passed in event callback
        onSubmit(post.id,{ body: commentBody });

        // Clear the input field
        setCommentBody("");
    };

    return (
        <div className="card CommentForm">
            <div className="card-body">
                <h5 className="card-title">Share your comment</h5>
                <div>
                    <div className="form-group">
            <textarea
                className="form-control"
                value={commentBody}
                onChange={(e) => setCommentBody(e.target.value)}
            />
                    </div>

                    <div className="form-group comment-submit">
                        <button className="btn btn-success" onClick={handleSubmit}>
                            Post
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}
