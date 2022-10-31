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

function createPostElement(post) { //  добавляет пост

    let ul = `<div id="like2" style="position: relative;">
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
                            <i class="bi bi-chat" id="show-button" type="button"> <p class ="button"></p> </i>
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

////////////******************************////////////////////

//кнопки
const likeBook = document.getElementById('bookmark');
likeBook.addEventListener('click', bookMark);


function bookMark(event) {
    let likeBook = event.currentTarget;
    let classes2 = likeBook.classList;

    if (classes2.contains('book2')) {
            classes2.replace('book2', 'muted1');
    } else {
            classes2.replace('muted1', 'book2');
    }
}

console.log(bookMark(event))


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

    console.log(parentOnClick2(event))


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

///////***************************************/////////////
//комментарии
//
//
//     function showCover() {
//         let coverDiv = document.createElement('div');
//         coverDiv.id = 'cover-div';
//
//         // убираем возможность прокрутки страницы во время показа модального окна с формой
//         document.body.style.overflowY = 'hidden';
//
//         document.body.append(coverDiv);
//     }
//
//
//     function hideCover() {
//         document.getElementById('cover-div').remove();
//         document.body.style.overflowY = '';
//     }
//
//     function showPrompt(text, callback) {
//         showCover();
//         let form = document.getElementById('prompt-form');
//         let container = document.getElementById('prompt-form-container');
//         document.getElementById('prompt-message').innerHTML = text;
//         form.text.value = '';
//
//         function complete(value) {
//             hideCover();
//             container.style.display = 'none';
//             document.onkeydown = null;
//             callback(value);
//         }
//
//         form.onsubmit = function () {
//             let value = form.text.value;
//             if (value == '') return false; // игнорируем отправку пустой формы
//
//             complete(value);
//             return false;
//         };
//
//         form.cancel.onclick = function () {
//             complete(null);
//         };
//
//         document.onkeydown = function (e) {
//             if (e.key == 'Escape') {
//                 complete(null);
//             }
//         };
//
//         let lastElem = form.elements[form.elements.length - 1];
//         let firstElem = form.elements[0];
//
//         lastElem.onkeydown = function (e) {
//             if (e.key == 'Tab' && !e.shiftKey) {
//                 firstElem.focus();
//                 return false;
//             }
//         };
//
//         firstElem.onkeydown = function (e) {
//             if (e.key == 'Tab' && e.shiftKey) {
//                 lastElem.focus();
//                 return false;
//             }
//         };
//
//         container.style.display = 'block';
//         form.elements.text.focus();
//     }
//
//     document.getElementById('show-button').onclick = function () {
//         showPrompt("Введите что-нибудь<br>...умное :)", function (value) {
//             alert("Вы ввели: " + value);
//         });
//     };

///////////////////**************










