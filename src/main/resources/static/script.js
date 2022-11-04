////////////////**************///////////////////
//отправка постов в базу данных///////
"use strict"
const BASE_URL = "http://localhost:9787"

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

function send(path, formData) {
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.post(BASE_URL+path, formData)
        .then((response)=>{
             // console.log(response.data);
            let postElement = createPostElement(response.data);
            addPost(postElement);
        })
        .catch((error) => {
            alert(error);
        })
}
//*******************************************************************//


document.getElementById("comment-form",)
    .addEventListener("submit", sendComment);

 function sendComment(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    commit("/comment", formData);
}
function commit(path, formData) {
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.post(BASE_URL+path, formData)
        .then((response)=>{
            // console.log(response.data);
            let postElement = createPostElement(response.data);
            addPost(postElement);
        })
        .catch((error) => {
            alert(error);
        })
}


document.getElementById("get_post").addEventListener("click", getPosts)
function getPosts(e) {
    axios.get(BASE_URL + '/post/all')
        .then(function (response) {
        //     console.log(response.data);
        // })
            let postElement = createPostElement(response.data);
            addPost(postElement);
        })
        .catch(function (error) {
            console.log(error);
        })
}


//////////////////////************************************************
function createPostElement(post) { //  добавляет пост

    let ul = `<div id="like2" class="pub" style="position: relative;">
            <div class="new-pub"> New publication: </div>
            <img class ="block w-30 displayed" src =" images/${post.image}" alt= "Post Image">
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
                            <i class="bi bi-chat" type="button" onclick="document.getElementById('id02').style.display='block'" style="width:auto;"> </i>
                        </span>
                    </li>
                    <li class="li2">
                        <span id="bookmark" class="h1 mx-2 muted book2">
                            <i class="bi bi-bookmark-fill"></i>
                        </span>
                    </li>
                </ul><br/>
            <div class="comment-1"> Description of post: ${post.description}</div>
        <div>`

    console.log(ul);
    let postElem = document.createElement('div');
    postElem.innerHTML = ul;
    return postElem;
};

function addPost(postElem) {
    document.getElementsByClassName("post")[0].after(postElem);
}
 // console.log(addPost(createPostElement(post)));


/////////////////***************************/////////////////
//регистрация

var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



var modalCommit = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modalCommit) {
        modal.style.display = "none";
    }
}
///**********************
//регистрация
const registrationForm = document.getElementById('registration-form');
registrationForm.addEventListener('submit', onRegisterHandler);

function onRegisterHandler(e){
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    var json = JSON.stringify(object);
    console.log(json);

    sendUser(json);
}

function sendUser(json) {
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.post(BASE_URL+'/database',
        json,
        {
            headers: {
                "Content-Type": "application/json"
            }
        }
    )
        .then(function (response) {
            console.log(response);
        })
        .catch(function (error) {
            console.log(error);
        })
        .then(function (other) {
            alert("Запрос был отправлен, результат в консоли")
        })
}
////////////////**************/////////////////////////////

const loginForm = document.getElementById('login-form');
loginForm.addEventListener('submit', onLoginHandler);


function onLoginHandler(e) {

        e.preventDefault(e);
        const form = e.target;
        const userFormData = new FormData(form);
        const user = Object.fromEntries(userFormData);
        saveUser(user);
        fetchAuthorised(BASE_URL + '/database')
            .then(function (response) {
                console.log(response);
            })

    }

    function saveUser(user) {
        const userAsJSON = JSON.stringify(user)
        localStorage.setItem('user', userAsJSON);

    }


    function restoreUser() {
        const userAsJSON = localStorage.getItem('user');
        const user = JSON.parse(userAsJSON);
        return user;

    }

function updateOptions(options) {
    const update = { ...options };
    update.mode = 'cors';
    update.headers = { ... options.headers };
    update.headers['Content-Type'] = 'application/json';
    const user = restoreUser();
    if(user) {
         update.headers['Authorization'] = 'Basic ' + btoa(user.name + ':' + user.password);

    }
    return update;

}


function fetchAuthorised(url, options) {
    const settings = options || {}
    return fetch(url, updateOptions(settings));

}


function createUserInfo(user){
     document.getElementById('info')
    .add.innerText(user.name);

}
console.log(createUserInfo(user))









// document.getElementById("get_user").addEventListener("click", getUsers)
// function getUsers(e) {
//         axios.post(BASE_URL + '/database/')
//             .then(function (response) {
//                 console.log(response.data);
//             })
//             .catch(function (error) {
//                 console.log(error);
//             })
//
// }



////////////******************************////////////////////

//кнопки
// const likeBook = document.getElementById('bookmark');
// likeBook.addEventListener('click', bookMark);
//
//
// function bookMark(event) {
//     let likeBook = event.currentTarget;
//     let classes2 = likeBook.classList;
//
//     if (classes2.contains('book2')) {
//             classes2.replace('book2', 'muted1');
//     } else {
//             classes2.replace('muted1', 'book2');
//     }
// }
//
// console.log(bookMark(event))

//
// const bigHeart = document.getElementById('like2');
// bigHeart.addEventListener('dblclick', parentOnClick2);
//
// function parentOnClick2(event) {
//     let like = event.currentTarget.lastElementChild.firstElementChild;
//
//     like.hidden = false;
//     setTimeout(
//         () => {
//             console.log('Hello after 4 seconds');
//             like.hidden = true;
//             },
//             1 * 1000
//         );
//         let like1 = document.getElementById('like');
//
//         like1.classList.replace('muted', 'text-danger');
//     }
// console.log(parentOnClick2(event))
//
//
//     const likeBody = document.getElementById('like');
//     likeBody.addEventListener('click', like);
//
//     function like(event) {
//         let like = event.currentTarget;
//         let classes = like.classList;
//
//         if (classes.contains('text-danger')) {
//             classes.replace('text-danger', 'muted');
//         } else {
//             classes.replace('muted', 'text-danger');
//         }
//     }

///////***************************************/////////
// function showSplashScreen() { //показать  splash
//     document.querySelector('.splash').hidden = false;
// };
// console.log(showSplashScreen());
//
//
// document.querySelector('.btn-lg'). // скрыть сплеш скрин по клику
//     // addEventListener('click', hideSplashOnClick);
// //
// // function hideSplashOnClick() {
// //     document.querySelector('.splash').hidden = true;
// // }
// console.log(hideSplashOnClick);
//



///////////////////**************










