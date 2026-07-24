package com.pdg.backed.domain.collection;

import java.util.Collection;
import java.util.List;

public record UpdateCollectionRequest(String title, List<Collection> collections) {}