"use strict"
const BASE_URL = "http://localhost:9678"

document.getElementById("post-form",)
    .addEventListener("submit", sendPost);


function sendPost(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    send("/post", formData);
}

function secury(val) {
    return val+"===";
}


function send(path, formData) {
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.post(BASE_URL+path, formData)
        .then((response)=>{
            console.log(response.data);
            let postElement = createPostElement(response.data);
            addPost(postElement);
        })
        .catch((error) => {
            alert(error);
        })
}

document.getElementById("get_posts").addEventListener("click", getPosts)

function getPosts(event) {
    axios.get(BASE_URL+'/post')
        .then(function (response) {
            console.log(response.data);
        })
        .catch(function (error) {
            console.log(error);
        })
}




let comment = {
    commentText: "Woo-ow! So cool!",
    commentDate: "16.10.2022",
    email: "kim@gmail.com"
};

function createCommentElement(comment) {   //  добавляет комментарий
    const ul = `    <p class="comment">User ${comment.email} commented:</p>
                    <ul>
                        <li>${comment.commentText}</li>
                        <li>${comment.commentDate}</li>
                    </ul>`;

    let newElem = document.createElement('div');
    newElem.innerHTML = ul;
     document.getElementsByClassName("active")[0].after(newElem);
};

  console.log(createCommentElement(comment));



function createPostElement(post) { //  добавляет пост
    let ul =`
        <div id="like2" style="position: relative;">
            <div>New publication: </div>
            <img class ="block w-30" src = "..static/images/${post.image}" alt= "Post Image">
            <div> Description of post: ${post.description}</div>
            <div style="position: absolute;top: 180px; right: 650px;">
                <span hidden class="h1 mx-2 text-danger icon">
                    <i class="bi bi-heart-fill"></i>
                </span>
            </div>
        </div>
        <div>
            <div style="height: 50px;">
                <ul class="ul1">
                    <li class="li2">
                        <span id="like" class="h1 mx-2 muted icon">
                            <i class="bi bi-heart-fill"></i>
                        </span>
                    </li>
                    <li class="li2">
                        <span id="chat" class="h1 mx-2 muted icon">
                            <i class="bi bi-chat"> <p class ="button"></p> </i>
                        </span>
                    </li>
                    <li class="li2">
                        <span id="bookmark" class="h1 mx-2 muted book2">
                            <i class="bi bi-bookmark-fill"></i>
                        </span>
                    </li>
                </ul>
            </div>
        <div>
    `
    console.log(ul);
    let postElem = document.createElement('div');
    postElem.innerHTML = ul;
    return postElem;
};

function addPost(postElem) {
      document.getElementsByClassName("post")[0].after(postElem);
}



const likeBook = document.getElementById('bookmark');
// likeBook.addEventListener('click', bookMark);


function bookMark(event) {
    let likeBook = event.currentTarget;
    let classes2 = likeBook.classList;

    if (classes2.contains('book2')) {
        classes2.replace('book2', 'muted1');
    } else {
        classes2.replace('muted1', 'book2');
    }
}

const bigHeart = document.getElementById('like2');
bigHeart.addEventListener('dblclick', parentOnClick2);

function parentOnClick2(event) {
    let like = event.currentTarget.lastElementChild.firstElementChild;

    like.hidden = false;
    setTimeout(
        () => {
            console.log('Hello after 4 seconds');
            like.hidden = true;
        },
        1 * 1000
    );
    let like1 = document.getElementById('like');

    like1.classList.replace('muted', 'text-danger');

}

const likeBody = document.getElementById('like');
likeBody.addEventListener('click', like);

function like(event) {
    let like = event.currentTarget;
    let classes = like.classList;

    if (classes.contains('text-danger')) {
        classes.replace('text-danger', 'muted');
    } else {
        classes.replace('muted', 'text-danger');
    }
}









