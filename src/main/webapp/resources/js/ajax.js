$(document).ready(deleteAuthor());

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
            success:function (res) {
                $('#authorItem' + authorId).remove();
            }
        });
    });
}
