import React, {useEffect} from "react";

import PostsApi from "../../api/PostsApi";

export default function PostUpdate ({onSubmite, postId}) {
    const [body, setBody] = React.useState("");

    useEffect(() => {
        (async ()=> {
            const post = await PostsApi.getPostById(postId);
            setBody(post.data); 
        })();
    },[]);

        
    // todo: test
    async function updatePost() {
        try {
            const post = {body: body};
            const response = await PostsApi.updatePost(post, postId);
            PostsApi.getPostById(postId)
                .then(response=>onSubmite(response.body))
                .catch(error=>console.log(error))
            if (response.status == 200) {
                this.props.history.push("/posts");
            }


        }
        // to be updated
        catch (err){};
    }

    return (
        <div className="card PostUpdate">
            <div className="card-body">
                <h5 className="card-title">Update post</h5>
                <div>
                    <div className="form-group">
            <textarea
                className="form-control"
                onChange={(e) => setBody(e.target.value)}
            />
                    </div>

                    <div className="form-group">

                            <button className="btn btn-info" onClick={updatePost}>
                                Update
                            </button>
                    </div>
                </div>
            </div>
        </div>
    );
}
