package com.mohsinkd786.api;

import com.mohsinkd786.domain.model.Role;
import com.mohsinkd786.service.UserService;
import com.mohsinkd786.domain.dto.CreateUserRequest;
import com.mohsinkd786.domain.dto.ListResponse;
import com.mohsinkd786.domain.dto.SearchRequest;
import com.mohsinkd786.domain.dto.SearchUsersQuery;
import com.mohsinkd786.domain.dto.UpdateUserRequest;
import com.mohsinkd786.domain.dto.UserView;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Tag(name = "UserAdmin")
@RestController @RequestMapping(path = "api/admin/user")
@RolesAllowed(Role.USER_ADMIN)
@RequiredArgsConstructor
public class UserAdminApi {

    private final UserService userService;

    @PostMapping
    public UserView create(@RequestBody @Valid CreateUserRequest request) {
        return userService.create(request);
    }

    @PutMapping("{id}")
    public UserView update(@PathVariable String id, @RequestBody @Valid UpdateUserRequest request) {
        return userService.update(new ObjectId(id), request);
    }

    @DeleteMapping("{id}")
    public UserView delete(@PathVariable String id) {
        return userService.delete(new ObjectId(id));
    }

    @GetMapping("{id}")
    public UserView get(@PathVariable String id) {
        return userService.getUser(new ObjectId(id));
    }

    @PostMapping("search")
    public ListResponse<UserView> search(@RequestBody SearchRequest<SearchUsersQuery> request) {
        return new ListResponse<>(userService.searchUsers(request.getPage(), request.getQuery()));
    }

}
