// NPM Packages
import React, { useEffect, useState } from "react";

// Project files
import Comment from "./Comment";
import CommentsApi from "../../../api/CommentsApi";

export default function CommentList({ post }) {
    // Local state
    const [comments, setComments] = useState([]);

    // Components
    const postId = post.id;
    const CommentsArray = comments.map((comment) => (
        <Comment key={comment.id} comment={comment} onDeleteClick={() => deleteComment(comment)} />
    ));

    // Methods
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
    }, [setComments]);

    return (
        <div>
            {CommentsArray}
        </div>
    )

}