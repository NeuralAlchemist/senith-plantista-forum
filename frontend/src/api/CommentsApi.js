import Api from "./Api";

class CommentsApi {
    getAllComments(postId) {
        return Api.get('/posts/'+postId+'/comments');
    }

    getCommentById(id) {
        return Api.get('/comments/'+id);
    }

    createComment(postId, comment) {
        return Api.comment('/posts/'+postId+'/comments', comment);
    }

    deleteComment(id) {
        return Api.delete('/comments/'+id);
    }
}

export default new CommentsApi();