// JavaScript Document
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "deleteUser?user.euUserId=" + id;
	}
}
function DeleteCategory(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "category_delete?category.epcId=" + id;
	}
}
function DeleteProduct(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "product_delete?product.epcId=" + id;
	}
}
function DeleteNews(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "news_delete?product.epcId=" + id;
	}
}
function DeleteNews(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "comment_delete?product.epcId=" + id;
	}
}