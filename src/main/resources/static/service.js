let books = [];

const callGet = async (url) => {
    const serverData = await fetch(url,{
        mode: "no-cors"
    });
    const book = await serverData.json();
    return book;
}
const callPost = async (url, data = {}) => {
    const serverData = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    const books = await serverData.json();
    return books;
}

$("#button-search").on("click", async () => {
    const data = $("#param").val().trim();
    console.log(data)
    const res = await callGet(`/getOneBook/${data}`);
    repaintAll(res);
});
$("#get-all").on("click",  () => {

    repaintAll(books);
});

$("#add-book").on("click", async (e) => {
    e.preventDefault();
    const name = $("#exampleFormControlInput1").val();
    const author = $("#exampleFormControlInput2").val();
    const isbn = $("#exampleFormControlInput3").val();
    const description = $("#exampleFormControlTextarea1").val();
    const book = {name: name, author: author, isbn: isbn, description: description};
    const res = await callPost('/addBook', book);
    res !== null ? books.push(res) : alert("Something went wrong");
    repaint();
})

const repaint = () => {
    appendLastBook();
}
const repaintAll = (books) => {
    const root = $("#root");
    root.html("");
    booksAppend(books);
}

const booksAppend = (book) => {
    const root = $("#root");
    book.forEach(item => {
        root.append(getBookHTML(item));
    })
}

const appendLastBook = () => {
    const root = $("#root");
    root.append(getBookHTML(books[books.length - 1]))
}

const getBookHTML = (book) => {
    return "<div " +
        "             class=\"card m-3\"\n" +
        "             style=\"width: 18rem;\">\n" +
        "            <div class=\"card-body\">\n" +
        "                <h5 " +
        "                  class=\"card-title\">" + book.name + "</h5>\n" +
        "                <h5 " +
        "                    class=\"card-subtitle mb-2 text-muted\">" + book.author + "</h5>\n" +
        "                <h6 " +
        "                    class=\"card-subtitle mb-2 text-muted\">" + book.isbn + "</h6>\n" +
        "                <p " +
        "                   class=\"card-text\">" + book.description + "</p>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</div>"
}