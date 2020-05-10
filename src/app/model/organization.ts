import { Domain } from './domain';

export class Organization{
    id: number;
    name: string;
    businessSector: string;
    domainObj: Domain;
    activate: boolean
}