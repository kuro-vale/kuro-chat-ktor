<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
    <meta charset="utf-8">
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
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#general-collapse" aria-expanded="true">
                      General
                    </button>
                    <div class="collapse show" id="general-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded"># general-01</a></li>
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded"># general-02</a></li>
                      </ul>
                    </div>
                  </li>
                  <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#whispers-collapse" aria-expanded="false">
                      Whispers
                    </button>
                    <div class="collapse" id="whispers-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded"># Kurovale</a></li>
                      </ul>
                    </div>
                  </li>
                  <li class="border-top my-3"></li>
                  <li class="mb-1">
                    <button class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
                      Account
                    </button>
                    <div class="collapse" id="account-collapse">
                      <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Register</a></li>
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Login</a></li>
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Profile</a></li>
                        <li><a href="#" class="link-dark d-inline-flex text-decoration-none rounded">Sign out</a></li>
                      </ul>
                    </div>
                  </li>
                </ul>
            </div>
        </div>
        <div class="d-flex flex-column container">
            <nav class="navbar navbar-expand-lg bg-light">
                <div class="container-fluid d-flex justify-content-between">
                    <a class="navbar-brand" role="button" data-bs-toggle="collapse" data-bs-target="#collapseSide" aria-expanded="true" aria-controls="collapseSide">|||</a>
                    <h2># general-01</h2>
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