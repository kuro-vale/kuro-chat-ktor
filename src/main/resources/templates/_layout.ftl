<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Kuro Chat</title>
        <link rel="icon" href="/static/favicon.ico">
        <link rel="stylesheet" href="/static/sidebar.css">
        <!-- Bootstrap 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
    <main class="d-flex flex-nowrap">
        <div class="collapse collapse-horizontal show" id="collapseSide">
            <div class="flex-shrink-0 p-3 bg-white" style="width: 240px; height: 100vh">
                <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
                  <img src="/static/favicon.ico" width="30" height="24"> &nbsp;
                  <span class="fs-5 fw-semibold">Kuro Chats</span>
                </a>
                <ul class="list-unstyled ps-0">
                  <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#general-collapse" aria-expanded="false">
                      General
                    </button>
                    <div class="collapse" id="general-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="/general-english" class="link-dark d-inline-flex text-decoration-none rounded"># general-english</a></li>
                        <li><a href="/general-spanish" class="link-dark d-inline-flex text-decoration-none rounded"># general-español</a></li>
                      </ul>
                    </div>
                  </li>
                  <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#topics-collapse" aria-expanded="false">
                      Topics
                    </button>
                    <div class="collapse" id="topics-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="/games" class="link-dark d-inline-flex text-decoration-none rounded"># games</a></li>
                        <li><a href="/movies" class="link-dark d-inline-flex text-decoration-none rounded"># movies</a></li>
                        <li><a href="/books" class="link-dark d-inline-flex text-decoration-none rounded"># books</a></li>
                      </ul>
                    </div>
                  </li>
                  <li class="border-top my-3"></li>
                  <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="true">
                      Account
                    </button>
                    <div class="collapse show" id="account-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <#if authenticated>
                            <li><a href="/profile" class="link-dark d-inline-flex text-decoration-none rounded">Profile</a></li>
                            <li>
                                <form action="/auth/logout" method="post">
                                <a onclick='this.parentNode.submit(); return false;' class="link-dark d-inline-flex text-decoration-none rounded">Sign out</a>
                                </form>
                            </li>
                        <#else>
                            <li><a href="/auth/register" class="link-dark d-inline-flex text-decoration-none rounded">Register</a></li>
                            <li><a href="/auth/login" class="link-dark d-inline-flex text-decoration-none rounded">Login</a></li>
                        </#if>
                      </ul>
                    </div>
                  </li>
                </ul>
            </div>
        </div>
        <div class="d-flex flex-column container">
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid d-flex justify-content-between">
                    <a class="navbar-brand" role="button" data-bs-toggle="collapse" data-bs-target="#collapseSide" aria-expanded="true" aria-controls="collapseSide">
                        <svg width="24" height="24" xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd"><path d="M14 19h-14v-1h14v1zm9.247-8.609l-3.247 4.049-3.263-4.062-.737.622 4 5 4-5-.753-.609zm-9.247 2.609h-14v-1h14v1zm0-6h-14v-1h14v1z"/></svg>
                    </a>
                    <h3>Give me a ⭐ in my <a class="link-dark" href="https://github.com/kuro-vale/kuro-chat-ktor" target="_blank">GitHub</a></h2>
                    <p></p>
                </div>
            </nav>
            <#nested>
        </div>
        </main>
        <!-- Bootstrap JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
    </html>
</#macro>