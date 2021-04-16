import Api from "./Api";

class CommentsApi {
    getAllComments() {
        return Api.get('/comments');
    }

    getCommentById(id) {
        return Api.get('/comments/'+id);
    }

    createComment(comment) {
        return Api.comment('/comments', comment);
    }

    updateComment (comment) {
        return Api.put('/comments', comment);
    }

    deleteComment(id) {
        return Api.delete('/comments/'+id);
    }
}

export default new CommentsApi();