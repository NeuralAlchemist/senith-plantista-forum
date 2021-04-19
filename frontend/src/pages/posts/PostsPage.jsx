// NPM Packages
import React, { useEffect, useState } from "react";

// Project files
import PostsApi from "../../api/PostsApi";
import Form from "./Form";
import Card from "./Card";

export default function PostsPage() {
  // Local state
  const [posts, setPosts] = useState([]);

  // Methods
  async function createPost(postData) {
    try {
      const response = await PostsApi.createPost(postData);
      const post = response.data;
      const newPosts = posts.concat(post);

      setPosts(newPosts);
    } catch (e) {
      console.error(e);
    }
  }

  async function deletePost(post) {
    try {
      await PostsApi.deletePost(post.id);
      const newPosts = posts.filter((p) => p.id !== post.id);

      setPosts(newPosts);
    } catch (e) {
      console.error(e);
    }
  }

  // todo: test
  async function updatePost(post) {
    try {
      await PostsApi.updatePost(post.id);


      // Component
      // Click "update" button, you want to (button in Card.jsx)

      //    fetch post (and respective text) to be updated
      //    display active text input box that allows user input
            // i understand this should be in the Card.jsx
      // save new input to the same post fetched. (Api)
      // display the post as normal

      // current post, updated post
      // save the updated post in the current post.id (is this what the API does?)
    }
  }

  useEffect(() => {
    PostsApi.getAllPosts()
      .then(({ data }) => setPosts(data))
      .catch((err) => console.error(err));
  }, [setPosts]);

  // Components
  const CardsArray = posts.map((post) => (
    <Card key={post.id} post={post} onDeleteClick={() => deletePost(post)} />
  ));

  return (
    <div>
      <Form onSubmit={(postData) => createPost(postData)} />

      {CardsArray}
    </div>
  );
}
