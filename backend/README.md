<pre>
api              |      url       |    method
--------------------------------------------------
User signup      |  /signup       |     POST
search meals     |  /meals/?      |     GET
add meal         |  /meals        |     POST
delete meal      |  /meals/?      |     DELETE
modify meal      |  /meals/?      |     PUT
</pre>

auth:
path: /auth
method:Post
header: {content-type: application/json}
data: {username:xxx,password:xxx}

return a jwt token in response header 




