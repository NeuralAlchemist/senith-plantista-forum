import React from "react";

import PostsApi from "../../api/PostsApi";

export default function PostUpdate ({postId}) {
    const [body, setBody] = React.useState("");

    //fetch the post from API
    const post = PostsApi.getPostById(postId);
    console.log(post);
    setBody(post.data);
    // todo: test
    async function updatePost(post) {
        try {
            post.body = body;
            const response = await PostsApi.updatePost(post);
            if (response.status == 200) {
                this.props.history.push("/posts");
            }
        }
        // to be updated
        catch (err){};
    }

    return (
        <div className="card">
            <div className="card-body">
                <h4 className="card-title">Update post</h4>
                <div>
                    <div className="form-group">
            <textarea
                className="form-control"
                value={body}
                onChange={(e) => setBody(e.target.value)}
            />
                    </div>

                    <div className="form-group">

                            <button className="btn btn-success" onClick={updatePost}>
                                Update the post
                            </button>
                    </div>
                </div>
            </div>
        </div>
    );
}
