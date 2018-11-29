$(document).ready(deleteAuthor())
$(document).ready(deleteBook())

function deleteAuthor () {
    $(document).on("click", 'button[name=authorId]', function (e) {
        const id = e.target.id;
        const authorId = $('#' + id).val();
        $.ajax({
            url: '/admin/author?authorId=' + authorId,
            type: "DELETE",
            data: {
                authorId: authorId
            },
            success:function () {

                $('#authorItem' + authorId).remove();
            }
        });
    });
}

function deleteBook() {
    $(document).on("click", 'button[name=deleteBookBtn]', function (e) {
        const id = e.target.id;
        const bookId = $('#' + id).val();
        $.ajax({
            url: '/admin/book?bookId=' + bookId,
            type: "DELETE",
            data: {
                bookId: bookId
            },
            success:function () {
                $('#bookItem' + bookId).remove();
            }
        });
    });
}
