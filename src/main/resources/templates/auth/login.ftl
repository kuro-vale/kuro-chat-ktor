<#import "../_layout.ftl" as layout />
<@layout.header>
    <h1 class="text-center fst-italic m-4">Login</h1>
    <div class="container-fluid d-flex justify-content-center align-items-center" style="height: 60vh">
        <form action="/auth/login" method="post" class="w-50">
            <div class="input-group d-flex flex-column flex-nowrap">
              <span class="input-group-text rounded mt-3" id="addon-wrapping">Username</span>
              <input type="text" class="form-control w-100 rounded"aria-label="Username" name="username" required="true">
              <span class="input-group-text rounded mt-3">Password</span>
              <input type="password" class="form-control w-100 rounded" name="password" required="true">
              <button type="submit" class="btn btn-outline-primary rounded mt-3">Login</button>
            </div>
        </form>
    </div>
</@layout.header>