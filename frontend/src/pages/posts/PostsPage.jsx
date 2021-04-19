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
      // filter for the id and change all values to the new
      const newPosts = posts.concat(post);

      setPosts(newPosts);
    } catch (e) {
      console.error(e);
    }
  }

  async function deletePost(post) {
    try {
      await PostsApi.deletePost(post.id);
      const response = await PostsApi.getAllPosts()
      setPosts(response.data);

      //setPosts(newPosts);
    } catch (e) {
      console.error(e);
    }
  }


  useEffect(() => {
    PostsApi.getAllPosts()
      .then(({ data }) => setPosts(data))
      .catch((err) => console.error(err));
  }, []);

  // Components
  const CardsArray = posts? posts.map((post) => (
    <Card key={post.id} post={post} onDeleteClick={() => deletePost(post)}/>
  )): null;

  return (

    <div>
      <Form onSubmit={(postData) => createPost(postData)} />

      {CardsArray}
    </div>
  );
}
