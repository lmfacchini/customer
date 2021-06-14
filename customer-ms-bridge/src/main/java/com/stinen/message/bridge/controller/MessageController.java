package com.stinen.message.bridge.controller;

import com.stinen.message.bridge.constants.MessageStatus;
import com.stinen.message.bridge.to.MessageTO;
import nom.framework.springbased.RestfulController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@RequestMapping
public interface MessageController extends RestfulController {

    @RequestMapping(method = RequestMethod.POST, value = "/protected/create")
    @PreAuthorize("hasAuthority('MS01')")
    ResponseEntity<MessageTO> create(@Valid @RequestBody MessageTO to);

    @RequestMapping(method = RequestMethod.GET, value = "/protected/listMyMessages")
    @PreAuthorize("hasAuthority('MS01')")
    ResponseEntity<Collection<MessageTO>> listMyMessages(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size);

    @RequestMapping(method = RequestMethod.POST, value = "/protected/setStatus")
    @PreAuthorize("hasAuthority('MS01')")
    ResponseEntity<MessageTO> setStatus(@RequestBody MessageTO message);

    @RequestMapping(method = RequestMethod.GET, value = "/protected/countByStatus/{status}")
    @PreAuthorize("hasAuthority('MS01')")
    ResponseEntity<Integer> countByStatus(@PathVariable(name = "status") MessageStatus status);


    @RequestMapping(method = RequestMethod.DELETE, value = "/protected/remove")
    @PreAuthorize("hasAuthority('MS01')")
    ResponseEntity<Collection<MessageTO>> remove(@RequestParam(name = "ids") Set<String> ids);





}
